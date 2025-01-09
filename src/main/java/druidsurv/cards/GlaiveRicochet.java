package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.defect.DamageAllButOneEnemyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import druidsurv.cards.cardvars.CardTags;

import static druidsurv.ModFile.makeID;

public class GlaiveRicochet extends AbstractEasyCard {
    public final static String ID = makeID("GlaiveRicochet");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public GlaiveRicochet() {
        super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 12;
        baseSecondDamage = 2;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        tags.add(druidsurv.cards.cardvars.CardTags.UNIQUE);
        tags.add(druidsurv.cards.cardvars.CardTags.RELOAD);
        this.exhaust = true;
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        int temp = AbstractDungeon.getCurrRoom().monsters.monsters.size();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < temp; j++) {
                AbstractMonster a = AbstractDungeon.getCurrRoom().monsters.monsters.get(j);
                if (a == m)
                {
                    dmg(a, AbstractGameAction.AttackEffect.SLASH_VERTICAL); // Deal normal damage.
                }
                else
                {
                    altDmg(a, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL); // Otherwise damage based on secondDamage.
                }
            }
        }
    }

    @Override
    public void upp() {
        upgradeDamage(9);
    }
}