package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.OnFire;
import druidsurv.powers.threedelaybloon;

import static druidsurv.ModFile.makeID;

public class SpicyMortarMonkey extends AbstractEasyCard {
    public final static String ID = makeID("SpicyMortar");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SpicyMortarMonkey() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        baseDamage = 12;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.FIRE));
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new OnFire(m, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeDamage(6);
    }
}