package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static druidsurv.ModFile.makeID;

public class MortarMonkey extends AbstractEasyCard {
    public final static String ID = makeID("Mortar");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public MortarMonkey() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ALL_ENEMY);
        baseDamage = 12;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.FIRE));
    }

    @Override
    public void upp() {
        upgradeDamage(6);
    }
}