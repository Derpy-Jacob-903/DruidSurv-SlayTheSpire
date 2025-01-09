package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.powers.reload;
import druidsurv.powers.zerodelaybloon;

import static druidsurv.ModFile.makeID;

public class TackShooter extends AbstractEasyCard {
    public final static String ID = makeID("TackShooter");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public TackShooter() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 6;
        tags.add(druidsurv.cards.cardvars.CardTags.DEFENDER);
        tags.add(druidsurv.cards.cardvars.CardTags.RELOAD);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.exhaust = true;
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new reload(m, 1), 1, true, AbstractGameAction.AttackEffect.NONE));

    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}