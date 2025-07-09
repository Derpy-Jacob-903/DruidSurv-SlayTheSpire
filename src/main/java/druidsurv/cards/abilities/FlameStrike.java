package druidsurv.cards.abilities;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.cards.AbstractPowerCostCard;
import druidsurv.powers.OnFire;

import static druidsurv.ModFile.NemCharacterColor;
import static druidsurv.ModFile.makeID;

public class FlameStrike extends AbstractPowerCostCard {
    public final static String ID = makeID("FlameStrike");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public FlameStrike() {
        super(ID, 5, CardType.ATTACK, CardRarity.RARE, CardTarget.ALL_ENEMY, CharacterFile.Enums.NEMDRUID_COLOR, "Firestorm_CardArt");
        //PurgeField.purge.set(this, true);
        baseDamage = 50;
        baseMagicNumber = 9;
        magicNumber = baseMagicNumber;
        //this.exhaust = true;
        isMultiDamage = true;
        retain = true;
        tags.add(CardTags.STRIKE);
        setBackgroundTexture("druidsurvResources/images/512/hero_attack.png", "druidsurvResources/images/1024/hero_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        int temp = AbstractDungeon.getCurrRoom().monsters.monsters.size();
        for (int j = 0; j < temp; j++) {
        AbstractMonster a = AbstractDungeon.getCurrRoom().monsters.monsters.get(j);
            if (a == m)
            {
                dmg(a, AbstractGameAction.AttackEffect.FIRE); // Deal normal damage.
            }
            else
            {
                addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new OnFire(m, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.FIRE));
            }
        }
    }

    @Override
    public void upp() {
        upgradeDamage(9);
    }
}